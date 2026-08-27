public class LogLine {

    private String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        String code = this.logLine.substring(1, 4);
        return switch (code) {
            case "TRC" -> LogLevel.TRACE;
            case "DBG" -> LogLevel.DEBUG;
            case "INF" -> LogLevel.INFO;
            case "WRN" -> LogLevel.WARNING;
            case "ERR" -> LogLevel.ERROR;
            case "FTL" -> LogLevel.FATAL;
            default    -> LogLevel.UNKNOWN; 
        };
    }

    public String getOutputForShortLog() {
        LogLevel levelEnum = getLogLevel();
        int numericLevel = levelEnum.getLevel();
        String message = this.logLine.split(": ")[1];
        return numericLevel + ":" + message;        
    
    }
}
