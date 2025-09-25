public class Utils {

    public static void typewriter(String text, int delayMillis) 
    {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public static void loopingEllipsis(int cycles, int delayMillis) 
    {
        String[] states = {".", "..", "...", "   "}; // Including a blank stage for reset

        for (int i = 0; i < cycles; i++) {
            for (String state : states) {
                System.out.print("\r" + state); // \r returns to beginning of line
                try {
                    Thread.sleep(delayMillis);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        // Clear the line after it's done
        System.out.print("\r    \r");
    }

    public static void loopingEllipsisWithMessage(String message, int cycles, int delayMillis) 
        {
            String[] states = {".", "..", "...", "   "};

            for (int i = 0; i < cycles; i++) {
                for (String state : states) {
                    System.out.print("\r" + message + state);
                    try {
                        Thread.sleep(delayMillis);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            // Clear line after
            System.out.print("\r" + " ".repeat(message.length() + 3) + "\r");
        }


}
