package tomaszkopacz.meetbam.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Ltomaszkopacz/meetbam/service/TimeAgoTextProvider;", "", "()V", "ERROR", "", "FORMAT_DAYS", "FORMAT_HOURS", "FORMAT_MINUTES", "countTimeAgoInMin", "", "timestamp", "getCustomTimeAgoText", "timeAgo", "format", "app_debug"})
public final class TimeAgoTextProvider {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FORMAT_MINUTES = "MINUTES";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FORMAT_HOURS = "HOURS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FORMAT_DAYS = "DAYS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERROR = "TIME ERROR";
    public static final tomaszkopacz.meetbam.service.TimeAgoTextProvider INSTANCE = null;
    
    public final float countTimeAgoInMin(@org.jetbrains.annotations.NotNull()
    java.lang.String timestamp) {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCustomTimeAgoText(float timeAgo, @org.jetbrains.annotations.NotNull()
    java.lang.String format) {
        return null;
    }
    
    private TimeAgoTextProvider() {
        super();
    }
}