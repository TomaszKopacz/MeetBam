package tomaszkopacz.meetbam.interactor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Ltomaszkopacz/meetbam/interactor/DatabaseService;", "", "database", "Lcom/google/firebase/database/FirebaseDatabase;", "(Lcom/google/firebase/database/FirebaseDatabase;)V", "putPost", "", "post", "Ltomaszkopacz/meetbam/entity/Post;", "Companion", "app_debug"})
public final class DatabaseService {
    private final com.google.firebase.database.FirebaseDatabase database = null;
    private static final java.lang.String POSTS_REFERENCE = "posts";
    public static final tomaszkopacz.meetbam.interactor.DatabaseService.Companion Companion = null;
    
    public final void putPost(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.entity.Post post) {
    }
    
    public DatabaseService(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.FirebaseDatabase database) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Ltomaszkopacz/meetbam/interactor/DatabaseService$Companion;", "", "()V", "POSTS_REFERENCE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}