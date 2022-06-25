import java.io.IOException;

class temp {
    public static void main(String[] args) throws IOException {
        in.init(false);
        double val[] = { 0.0d, 0.0d, 1.0d, 0.0d };
        double arr[][] = new double[14][4];
        for (int i = 0; i < 14; i++) {
            arr[i][0] = in.readDouble() - 1;
            arr[i][1] = in.readDouble() - 1;
            arr[i][2] = in.readDouble() - 1;
            arr[i][3] = in.readDouble();

        }
        for (int i = 0; i < 4; i++) {
            double max[] = new double[4];
            String s[] = new String[4];
            s[0] = "";
            s[1] = "";
            s[2] = "";
            s[3] = "";
            for (int j = 0; j < 14; j++) {
                if (arr[j][0] == i) {
                    max[(int) arr[j][1]] += val[(int) arr[j][2]] * arr[j][3];
                    s[(int) arr[j][1]] += "" + ((int) (val[(int) arr[j][2]])) + " * " + ((int) arr[j][3] + 1) + " ,";
                    // System.out.print(val[(int) arr[j][2]] + "* " + arr[j][3] + " ,");

                }
            }
            double m = -1;
            for (int j2 = 0; j2 < 4; j2++) {
                m = Math.max(m, max[j2]);
                if (s[j2].length() != 0) {
                    System.out.println(s[j2]);
                }
            }
            System.out.println(m);
        }
        in.dinit();

    }
}