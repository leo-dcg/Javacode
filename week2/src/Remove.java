import java.util.Objects;

public class Remove {
//    public E remove(int index) {
//    // 检查索引是否越界，如果index >= size 或者 index < 0，会抛出IndexOutOfBoundsException
//    Objects.checkIndex(index, size);
//
//    // 将底层数组elementData赋值给局部变量es，elementData是存储ArrayList元素的真正数组
//    final Object[] es = elementData;
//
//    // 从数组中取出索引为index的元素并转换为泛型类型E，这里会有一个SuppressWarnings注解来抑制编译器对未检查转换的警告
//    @SuppressWarnings("unchecked")
//    E oldValue = (E) es[index];
//
//    // 调用fastRemove方法实际执行删除操作
//    fastRemove(es, index);
//
//    // 返回被删除的元素值
//    return oldValue;
//}

//   private void fastRemove(Object[] es, int i) {
//    // 修改结构次数增加，用于迭代时检测并发修改异常
//    modCount++;
//
//    // 需要移动的元素数量，等于当前size减去索引i+1
//    final int newSize;
//
//    // 如果i不是最后一个元素，则将i后面的所有元素向前移动一位
//    if (i < size - 1) {
//        // 使用System.arraycopy进行数组拷贝：
//        // 1. 源数组es（当前底层数组）
//        // 2. 源位置i+1（从i+1开始复制）
//        // 3. 目标数组es（同一个数组）
//        // 4. 目标位置i（从i开始粘贴）
//        // 5. 要复制的元素数量：size - i - 1
//        System.arraycopy(es, i + 1, es, i, size - i - 1);
//    }
//
//    // 将数组最后一个位置设为null，帮助垃圾回收
//    // 先将size减1，然后将该位置设置为null
//    es[--size] = null;
}

