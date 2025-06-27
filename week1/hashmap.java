public class hashmap {
    public class HashMap<K,V> extends AbstractMap<K,V>
            implements Map<K,V>, Cloneable, Serializable {

        @java.io.Serial
        private static final long serialVersionUID = 362498820763181265L;

        /*
         * Implementation notes.
         *
         * This map usually acts as a binned (bucketed) hash table, but
         * when bins get too large, they are transformed into bins of
         * TreeNodes, each structured similarly to those in
         * java.util.TreeMap. Most methods try to use normal bins, but
         * relay to TreeNode methods when applicable (simply by checking
         * instanceof a node).  Bins of TreeNodes may be traversed and
         * used like any others, but additionally support faster lookup
         * when overpopulated. However, since the vast majority of bins in
         * normal use are not overpopulated, checking for existence of
         * tree bins may be delayed in the course of table methods.
         *
         * Tree bins (i.e., bins whose elements are all TreeNodes) are
         * ordered primarily by hashCode, but in the case of ties, if two
         * elements are of the same "class C implements Comparable<C>",
         * type then their compareTo method is used for ordering. (We
         * conservatively check generic types via reflection to validate
         * this -- see method comparableClassFor).  The added complexity
         * of tree bins is worthwhile in providing worst-case O(log n)
         * operations when keys either have distinct hashes or are
         * orderable, Thus, performance degrades gracefully under
         * accidental or malicious usages in which hashCode() methods
         * return values that are poorly distributed, as well as those in
         * which many keys share a hashCode, so long as they are also
         * Comparable. (If neither of these apply, we may waste about a
         * factor of two in time and space compared to taking no
         * precautions. But the only known cases stem from poor user
         * programming practices that are already so slow that this makes
         * little difference.)
         *
         * Because TreeNodes are about twice the size of regular nodes, we
         * use them only when bins contain enough nodes to warrant use
         * (see TREEIFY_THRESHOLD). And when they become too small (due to
         * removal or resizing) they are converted back to plain bins.  In
         * usages with well-distributed user hashCodes, tree bins are
         * rarely used.  Ideally, under random hashCodes, the frequency of
         * nodes in bins follows a Poisson distribution
         * (http://en.wikipedia.org/wiki/Poisson_distribution) with a
         * parameter of about 0.5 on average for the default resizing
         * threshold of 0.75, although with a large variance because of
         * resizing granularity. Ignoring variance, the expected
         * occurrences of list size k are (exp(-0.5) * pow(0.5, k) /
         * factorial(k)). The first values are:
         *
         * 0:    0.60653066
         * 1:    0.30326533
         * 2:    0.07581633
         * 3:    0.01263606
         * 4:    0.00157952
         * 5:    0.00015795
         * 6:    0.00001316
         * 7:    0.00000094
         * 8:    0.00000006
         * more: less than 1 in ten million
         *
         * The root of a tree bin is normally its first node.  However,
         * sometimes (currently only upon Iterator.remove), the root might
         * be elsewhere, but can be recovered following parent links
         * (method TreeNode.root()).
         *
         * All applicable internal methods accept a hash code as an
         * argument (as normally supplied from a public method), allowing
         * them to call each other without recomputing user hashCodes.
         * Most internal methods also accept a "tab" argument, that is
         * normally the current table, but may be a new or old one when
         * resizing or converting.
         *
         * When bin lists are treeified, split, or untreeified, we keep
         * them in the same relative access/traversal order (i.e., field
         * Node.next) to better preserve locality, and to slightly
         * simplify handling of splits and traversals that invoke
         * iterator.remove. When using comparators on insertion, to keep a
         * total ordering (or as close as is required here) across
         * rebalancings, we compare classes and identityHashCodes as
         * tie-breakers.
         *
         * The use and transitions among plain vs tree modes is
         * complicated by the existence of subclass LinkedHashMap. See
         * below for hook methods defined to be invoked upon insertion,
         * removal and access that allow LinkedHashMap internals to
         * otherwise remain independent of these mechanics. (This also
         * requires that a map instance be passed to some utility methods
         * that may create new nodes.)
         *
         * The concurrent-programming-like SSA-based coding style helps
         * avoid aliasing errors amid all of the twisty pointer operations.
         */

        /**
         * The default initial capacity - MUST be a power of two.
         */         //默认初始容量
        static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

        /**
         * The maximum capacity, used if a higher value is implicitly specified
         * by either of the constructors with arguments.
         * MUST be a power of two <= 1<<30.
         */
        static final int MAXIMUM_CAPACITY = 1 << 30;

        /**
         * The load factor used when none specified in constructor.
         */         //默认负载因子
        static final float DEFAULT_LOAD_FACTOR = 0.75f;


        /**
         * The bin count threshold for using a tree rather than list for a
         * bin.  Bins are converted to trees when adding an element to a
         * bin with at least this many nodes. The value must be greater
         * than 2 and should be at least 8 to mesh with assumptions in
         * tree removal about conversion back to plain bins upon
         * shrinkage.
         */        //树化阈值
        static final int TREEIFY_THRESHOLD = 8;

        /**
         * The bin count threshold for untreeifying a (split) bin during a
         * resize operation. Should be less than TREEIFY_THRESHOLD, and at
         * most 6 to mesh with shrinkage detection under removal.
         */        //红黑树转链表阈值
        static final int UNTREEIFY_THRESHOLD = 6;

        /**
         * The smallest table capacity for which bins may be treeified.
         * (Otherwise the table is resized if too many nodes in a bin.)
         * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
         * between resizing and treeification thresholds.
         */        //最小树化容量
        static final int MIN_TREEIFY_CAPACITY = 64;

        /**
         * Basic hash bin node, used for most entries.  (See below for
         * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
         */
        static class Node<K,V> implements Map.Entry<K,V> {
            final int hash;
            final K key;
            V value;
            Node<K,V> next;

            Node(int hash, K key, V value, Node<K,V> next) {
                this.hash = hash;
                this.key = key;
                this.value = value;
                this.next = next;
            }

            public final K getKey()        { return key; }
            public final V getValue()      { return value; }
            public final String toString() { return key + "=" + value; }

            public final int hashCode() {
                return Objects.hashCode(key) ^ Objects.hashCode(value);
            }

            public final V setValue(V newValue) {
                V oldValue = value;
                value = newValue;
                return oldValue;
            }

            public final boolean equals(Object o) {
                if (o == this)
                    return true;

                return o instanceof Map.Entry<?, ?> e
                        && Objects.equals(key, e.getKey())
                        && Objects.equals(value, e.getValue());
            }
        }

        /* ---------------- Static utilities -------------- */

        /**
         * Computes key.hashCode() and spreads (XORs) higher bits of hash
         * to lower.  Because the table uses power-of-two masking, sets of
         * hashes that vary only in bits above the current mask will
         * always collide. (Among known examples are sets of Float keys
         * holding consecutive whole numbers in small tables.)  So we
         * apply a transform that spreads the impact of higher bits
         * downward. There is a tradeoff between speed, utility, and
         * quality of bit-spreading. Because many common sets of hashes
         * are already reasonably distributed (so don't benefit from
         * spreading), and because we use trees to handle large sets of
         * collisions in bins, we just XOR some shifted bits in the
         * cheapest possible way to reduce systematic lossage, as well as
         * to incorporate impact of the highest bits that would otherwise
         * never be used in index calculations because of table bounds.
         */       //通过讲hash值与右移16位后的值异或避免哈希冲突提高存储性能
        static final int hash(Object key) {
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }

        /**
         * Returns x's Class if it is of the form "class C implements
         * Comparable<C>", else null.
         */
        static Class<?> comparableClassFor(Object x) {
            if (x instanceof Comparable) {
                Class<?> c; Type[] ts, as; ParameterizedType p;
                if ((c = x.getClass()) == String.class) // bypass checks
                    return c;
                if ((ts = c.getGenericInterfaces()) != null) {
                    for (Type t : ts) {
                        if ((t instanceof ParameterizedType) &&
                                ((p = (ParameterizedType) t).getRawType() ==
                                        Comparable.class) &&
                                (as = p.getActualTypeArguments()) != null &&
                                as.length == 1 && as[0] == c) // type arg is c
                            return c;
                    }
                }
            }
            return null;
        }

        /**
         * Returns k.compareTo(x) if x matches kc (k's screened comparable
         * class), else 0.
         */
        @SuppressWarnings({"rawtypes","unchecked"}) // for cast to Comparable
        static int compareComparables(Class<?> kc, Object k, Object x) {
            return (x == null || x.getClass() != kc ? 0 :
                    ((Comparable)k).compareTo(x));
        }

        /**
         * Returns a power of two size for the given target capacity.
         */         //获取一个最接近不小于 cap 的2的幂例如输入5返回8输入10返回16
     }
        static final int tableSizeFor(int cap) {
            int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
            return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        }

        /* ---------------- Fields -------------- */

        /**
         * The table, initialized on first use, and resized as
         * necessary. When allocated, length is always a power of two.
         * (We also tolerate length zero in some operations to allow
         * bootstrapping mechanics that are currently not needed.)
         */
        transient Node<K,V>[] table;

        /**
         * Holds cached entrySet(). Note that AbstractMap fields are used
         * for keySet() and values().
         */
        transient Set<Map.Entry<K,V>> entrySet;

        /**
         * The number of key-value mappings contained in this map.
         */
        transient int size;

        /**
         * The number of times this HashMap has been structurally modified
         * Structural modifications are those that change the number of mappings in
         * the HashMap or otherwise modify its internal structure (e.g.,
         * rehash).  This field is used to make iterators on Collection-views of
         * the HashMap fail-fast.  (See ConcurrentModificationException).
         */
        transient int modCount;

        /**
         * The next size value at which to resize (capacity * load factor).
         *
         * @serial
         */
        // (The javadoc description is true upon serialization.
        // Additionally, if the table array has not been allocated, this
        // field holds the initial array capacity, or zero signifying
        // DEFAULT_INITIAL_CAPACITY.)
        int threshold;

        /**
         * The load factor for the hash table.
         *
         * @serial
         */
        final float loadFactor;

        /* ---------------- Public operations -------------- */

        /**
         * Constructs an empty {@code HashMap} with the specified initial
         * capacity and load factor.
         *
         * @apiNote
         * To create a {@code HashMap} with an initial capacity that accommodates
         * an expected number of mappings, use {@link #newHashMap(int) newHashMap}.
         *
         * @param  initialCapacity the initial capacity
         * @param  loadFactor      the load factor
         * @throws IllegalArgumentException if the initial capacity is negative
         *         or the load factor is nonpositive
         */
        public HashMap(int initialCapacity, float loadFactor) {
            if (initialCapacity < 0)
                throw new IllegalArgumentException("Illegal initial capacity: " +
                        initialCapacity);
            if (initialCapacity > MAXIMUM_CAPACITY)
                initialCapacity = MAXIMUM_CAPACITY;
            if (loadFactor <= 0 || Float.isNaN(loadFactor))
                throw new IllegalArgumentException("Illegal load factor: " +
                        loadFactor);
            this.loadFactor = loadFactor;
            this.threshold = tableSizeFor(initialCapacity);
        }

        /**
         * Constructs an empty {@code HashMap} with the specified initial
         * capacity and the default load factor (0.75).
         *
         * @apiNote
         * To create a {@code HashMap} with an initial capacity that accommodates
         * an expected number of mappings, use {@link #newHashMap(int) newHashMap}.
         *
         * @param  initialCapacity the initial capacity.
         * @throws IllegalArgumentException if the initial capacity is negative.
         */
        public HashMap(int initialCapacity) {
            this(initialCapacity, DEFAULT_LOAD_FACTOR);
        }

        /**
         * Constructs an empty {@code HashMap} with the default initial capacity
         * (16) and the default load factor (0.75).
         */
        public HashMap() {
            this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
        }

        /**
         * Constructs a new {@code HashMap} with the same mappings as the
         * specified {@code Map}.  The {@code HashMap} is created with
         * default load factor (0.75) and an initial capacity sufficient to
         * hold the mappings in the specified {@code Map}.
         *
         * @param   m the map whose mappings are to be placed in this map
         * @throws  NullPointerException if the specified map is null
         */
        public HashMap(Map<? extends K, ? extends V> m) {
            this.loadFactor = DEFAULT_LOAD_FACTOR;
            putMapEntries(m, false);
        }

        /**
         * Implements Map.putAll and Map constructor.
         *
         * @param m the map
         * @param evict false when initially constructing this map, else
         * true (relayed to method afterNodeInsertion).
         */
        final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
            int s = m.size();
            if (s > 0) {
                if (table == null) { // pre-size
                    double dt = Math.ceil(s / (double)loadFactor);
                    int t = ((dt < (double)MAXIMUM_CAPACITY) ?
                            (int)dt : MAXIMUM_CAPACITY);
                    if (t > threshold)
                        threshold = tableSizeFor(t);
                } else {
                    // Because of linked-list bucket constraints, we cannot
                    // expand all at once, but can reduce total resize
                    // effort by repeated doubling now vs later
                    while (s > threshold && table.length < MAXIMUM_CAPACITY)
                        resize();
                }

                for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                    K key = e.getKey();
                    V value = e.getValue();
                    putVal(hash(key), key, value, false, evict);
                }
            }
        }

        /**
         * Returns the number of key-value mappings in this map.
         *
         * @return the number of key-value mappings in this map
         */
        public int size() {
            return size;
        }

        /**
         * Returns {@code true} if this map contains no key-value mappings.
         *
         * @return {@code true} if this map contains no key-value mappings
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Returns the value to which the specified key is mapped,
         * or {@code null} if this map contains no mapping for the key.
         *
         * <p>More formally, if this map contains a mapping from a key
         * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
         * key.equals(k))}, then this method returns {@code v}; otherwise
         * it returns {@code null}.  (There can be at most one such mapping.)
         *
         * <p>A return value of {@code null} does not <i>necessarily</i>
         * indicate that the map contains no mapping for the key; it's also
         * possible that the map explicitly maps the key to {@code null}.
         * The {@link #containsKey containsKey} operation may be used to
         * distinguish these two cases.
         *
         * @see #put(Object, Object)
         */
        public V get(Object key) {
            Node<K,V> e;
            return (e = getNode(key)) == null ? null : e.value;
        }

        /**
         * Implements Map.get and related methods.
         *
         * @param key the key
         * @return the node, or null if none
         */
        final Node<K,V> getNode(Object key) {
            Node<K,V>[] tab; Node<K,V> first, e; int n, hash; K k;
            if ((tab = table) != null && (n = tab.length) > 0 &&
                    (first = tab[(n - 1) & (hash = hash(key))]) != null) {
                if (first.hash == hash && // always check first node
                        ((k = first.key) == key || (key != null && key.equals(k))))
                    return first;
                if ((e = first.next) != null) {
                    if (first instanceof TreeNode)
                        return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                    do {
                        if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                            return e;
                    } while ((e = e.next) != null);
                }
            }
            return null;
        }

        /**
         * Returns {@code true} if this map contains a mapping for the
         * specified key.
         *
         * @param   key   The key whose presence in this map is to be tested
         * @return {@code true} if this map contains a mapping for the specified
         * key.
         */
        public boolean containsKey(Object key) {
            return getNode(key) != null;
        }

        /**
         * Associates the specified value with the specified key in this map.
         * If the map previously contained a mapping for the key, the old
         * value is replaced.
         *
         * @param key key with which the specified value is to be associated
         * @param value value to be associated with the specified key
         * @return the previous value associated with {@code key}, or
         *         {@code null} if there was no mapping for {@code key}.
         *         (A {@code null} return can also indicate that the map
         *         previously associated {@code null} with {@code key}.)
         */
        public V put(K key, V value) {
            return putVal(hash(key), key, value, false, true);
        }

        /**
         * Implements Map.put and related methods.
         *
         * @param hash hash for key
         * @param key the key
         * @param value the value to put
         * @param onlyIfAbsent if true, don't change existing value
         * @param evict if false, the table is in creation mode.
         * @return previous value, or null if none
         */
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                       boolean evict) {
            Node<K,V>[] tab; Node<K,V> p; int n, i;
            if ((tab = table) == null || (n = tab.length) == 0)
                n = (tab = resize()).length;
            if ((p = tab[i = (n - 1) & hash]) == null)
                tab[i] = newNode(hash, key, value, null);
            else {
                Node<K,V> e; K k;
                if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                    e = p;
                else if (p instanceof TreeNode)
                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {
                    for (int binCount = 0; ; ++binCount) {
                        if ((e = p.next) == null) {
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);
                            break;
                        }
                        if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    }
                }
                if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    afterNodeAccess(e);
                    return oldValue;
                }
            }
            ++modCount;
            if (++size > threshold)
                resize();
            afterNodeInsertion(evict);
            return null;
        }

        /**
         * Initializes or doubles table size.  If null, allocates in
         * accord with initial capacity target held in field threshold.
         * Otherwise, because we are using power-of-two expansion, the
         * elements from each bin must either stay at same index, or move
         * with a power of two offset in the new table.
         *
         * @return the table
         */
        final Node<K,V>[] resize() {
            Node<K,V>[] oldTab = table;
            int oldCap = (oldTab == null) ? 0 : oldTab.length;
            int oldThr = threshold;
            int newCap, newThr = 0;
            if (oldCap > 0) {
                if (oldCap >= MAXIMUM_CAPACITY) {
                    threshold = Integer.MAX_VALUE;
                    return oldTab;
                }
                else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                        oldCap >= DEFAULT_INITIAL_CAPACITY)
                    newThr = oldThr << 1; // double threshold
            }
            else if (oldThr > 0) // initial capacity was placed in threshold
                newCap = oldThr;
            else {               // zero initial threshold signifies using defaults
                newCap = DEFAULT_INITIAL_CAPACITY;
                newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
            }
            if (newThr == 0) {
                float ft = (float)newCap * loadFactor;
                newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                        (int)ft : Integer.MAX_VALUE);
            }
            threshold = newThr;
            @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
            table = newTab;
            if (oldTab != null) {
                for (int j = 0; j < oldCap; ++j) {
                    Node<K,V> e;
                    if ((e = oldTab[j]) != null) {
                        oldTab[j] = null;
                        if (e.next == null)
                            newTab[e.hash & (newCap - 1)] = e;
                        else if (e instanceof TreeNode)
                            ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                        else { // preserve order
                            Node<K,V> loHead = null, loTail = null;
                            Node<K,V> hiHead = null, hiTail = null;
                            Node<K,V> next;
                            do {
                                next = e.next;
                                if ((e.hash & oldCap) == 0) {
                                    if (loTail == null)
                                        loHead = e;
                                    else
                                        loTail.next = e;
                                    loTail = e;
                                }
                                else {
                                    if (hiTail == null)
                                        hiHead = e;
                                    else
                                        hiTail.next = e;
                                    hiTail = e;
                                }
                            } while ((e = next) != null);
                            if (loTail != null) {
                                loTail.next = null;
                                newTab[j] = loHead;
                            }
                            if (hiTail != null) {
                                hiTail.next = null;
                                newTab[j + oldCap] = hiHead;
                            }
                        }
                    }
                }
            }
            return newTab;
        }

        /**
         * Replaces all linked nodes in bin at index for given hash unless
         * table is too small, in which case resizes instead.
         */
        final void treeifyBin(Node<K,V>[] tab, int hash) {
            int n, index; Node<K,V> e;
            if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                resize();
            else if ((e = tab[index = (n - 1) & hash]) != null) {
                TreeNode<K,V> hd = null, tl = null;
                do {
                    TreeNode<K,V> p = replacementTreeNode(e, null);
                    if (tl == null)
                        hd = p;
                    else {
                        p.prev = tl;
                        tl.next = p;
                    }
                    tl = p;
                } while ((e = e.next) != null);
                if ((tab[index] = hd) != null)
                    hd.treeify(tab);
            }
        }

        /**
         * Copies all of the mappings from the specified map to this map.
         * These mappings will replace any mappings that this map had for
         * any of the keys currently in the specified map.
         *
         * @param m mappings to be stored in this map
         * @throws NullPointerException if the specified map is null
         */
        public void putAll(Map<? extends K, ? extends V> m) {
            putMapEntries(m, true);
        }

        /**
         * Removes the mapping for the specified key from this map if present.
         *
         * @param  key key whose mapping is to be removed from the map
         * @return the previous value associated with {@code key}, or
         *         {@code null} if there was no mapping for {@code key}.
         *         (A {@code null} return can also indicate that the map
         *         previously associated {@code null} with {@code key}.)
         */
        public V remove(Object key) {
            Node<K,V> e;
            return (e = removeNode(hash(key), key, null, false, true)) == null ?
                    null : e.value;
        }

        /**
         * Implements Map.remove and related methods.
         *
         * @param hash hash for key
         * @param key the key
         * @param value the value to match if matchValue, else ignored
         * @param matchValue if true only remove if value is equal
         * @param movable if false do not move other nodes while removing
         * @return the node, or null if none
         */
        final Node<K,V> removeNode(int hash, Object key, Object value,
                                   boolean matchValue, boolean movable) {
            Node<K,V>[] tab; Node<K,V> p; int n, index;
            if ((tab = table) != null && (n = tab.length) > 0 &&
                    (p = tab[index = (n - 1) & hash]) != null) {
                Node<K,V> node = null, e; K k; V v;
                if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                    node = p;
                else if ((e = p.next) != null) {
                    if (p instanceof TreeNode)
                        node = ((TreeNode<K,V>)p).getTreeNode(hash, key);
                    else {
                        do {
                            if (e.hash == hash &&
                                    ((k = e.key) == key ||
                                            (key != null && key.equals(k)))) {
                                node = e;
                                break;
                            }
                            p = e;
                        } while ((e = e.next) != null);
                    }
                }
                if (node != null && (!matchValue || (v = node.value) == value ||
                        (value != null && value.equals(v)))) {
                    if (node instanceof TreeNode)
                        ((TreeNode<K,V>)node).removeTreeNode(this, tab, movable);
                    else if (node == p)
                        tab[index] = node.next;
                    else
                        p.next = node.next;
                    ++modCount;
                    --size;
                    afterNodeRemoval(node);
                    return node;
                }
            }
            return null;
        }


    }
