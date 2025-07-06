import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@NoArgsConstructor
@Data
public class Card {
    String size;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBallance() {
        return Ballance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", Ballance=" + Ballance +
                '}';
    }

    public void setBallance(int ballance) {
        Ballance = ballance;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Card(String size, String color, int ballance) {
        this.size = size;
        this.color = color;
        Ballance = ballance;
    }

    String color;
    int Ballance;
}
