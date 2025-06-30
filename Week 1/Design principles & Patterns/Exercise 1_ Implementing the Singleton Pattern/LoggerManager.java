class LoggerService {
    // Holds the single instance of LoggerService
    private static LoggerService instance;

    // Private constructor prevents outside instantiation
    private LoggerService() {
        // Initialization logic (if needed) goes here
    }

    // Thread-safe method to retrieve the singleton instance
    public static LoggerService getInstance() {
        if (instance == null) {
            synchronized (LoggerService.class) {
                if (instance == null) {
                    instance = new LoggerService();
                }
            }
        }
        return instance;
    }

    // Outputs a log message to the console
    public void log(String message) {
        System.out.println("LoggerService: " + message);
    }
}
