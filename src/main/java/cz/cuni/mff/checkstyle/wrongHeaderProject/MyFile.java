package cz.cuni.mff.checkstyle.wrongHeaderProject;

import java.util.List;
import java.util.Objects;

public class MyFile {
    private List<String> lines;

    public MyFile(List<String> lines) {
        this.lines = lines;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyFile myFile = (MyFile) o;
        return Objects.equals(lines, myFile.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
