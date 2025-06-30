public class SingletonDemo {
    public static void main(String[] args) {
        // Obtain two references to the same LoggerService singleton
        LoggerService loggerA = LoggerService.getInstance();
        LoggerService loggerB = LoggerService.getInstance();

        System.out.println();

        // Confirm both references point to the same object
        if (loggerA == loggerB) {
            System.out.println("Both LoggerService references are identical.");
        } else {
            System.out.println("Different instances were returned!");
        }

        // Log messages using both references
        loggerA.log("Initializing system...");
        loggerB.log("System running diagnostics.");
    }
}