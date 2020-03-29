package du;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Arguments{
    private Flags flags = new Flags(false, false, false);
    private List<String> files = new ArrayList<>();

    private Arguments(boolean hFlag, boolean cFlag, boolean siFlag, List<String> files) {
        this.flags = new Flags(hFlag, cFlag, siFlag);
        this.files = files;
    }

    private Arguments(Flags flags, List<String> files) {
        this.flags = flags;
        this.files = files;
    }

    Arguments(String[] args) throws IOException {
        for (int i = 0; i != args.length; i++){
            switch (args[i]){
                case ("du"):
                    break;
                case ("-h"):
                    flags.setHFlag(true);
                    break;
                case ("-c"):
                    flags.setCFlag(true);
                    break;
                case ("-si"):
                    flags.setSiFlag(true);
                    break;
                default:
                    files.add(args[i]);
                    break;
            }
        }

    }

    Flags getFlags(){
        return flags;
    }

    List<String> getFiles(){
        return files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arguments arguments = (Arguments) o;
        return flags == arguments.flags &&
                Objects.equals(files, arguments.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flags, files);
    }

    @Override
    public String toString() {
        return "Arguments{" +
                "flags=" + flags +
                ", files=" + files +
                '}';
    }
}