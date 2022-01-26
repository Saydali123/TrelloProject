package uz.elmurodov.security.organization;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Point extends org.postgresql.geometric.PGpoint {
    public Point(double x, double y) {
        super(x, y);
    }
}
