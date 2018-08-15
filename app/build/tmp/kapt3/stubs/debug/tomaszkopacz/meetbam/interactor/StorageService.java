package tomaszkopacz.meetbam.interactor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Ltomaszkopacz/meetbam/interactor/StorageService;", "", "firebaseStorage", "Lcom/google/firebase/storage/FirebaseStorage;", "(Lcom/google/firebase/storage/FirebaseStorage;)V", "getReference", "Lcom/google/firebase/storage/StorageReference;", "url", "", "uploadPostPhoto", "file", "Ljava/io/File;", "listener", "Ltomaszkopacz/meetbam/interactor/TaskListener;", "Companion", "app_debug"})
public final class StorageService {
    private final com.google.firebase.storage.FirebaseStorage firebaseStorage = null;
    private static final java.lang.String POSTS = "posts";
    private static final java.lang.String AVATARS = "avatars";
    public static final tomaszkopacz.meetbam.interactor.StorageService.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String uploadPostPhoto(@org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.Nullable()
    tomaszkopacz.meetbam.interactor.TaskListener listener) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.storage.StorageReference getReference(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    public StorageService(@org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.FirebaseStorage firebaseStorage) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Ltomaszkopacz/meetbam/interactor/StorageService$Companion;", "", "()V", "AVATARS", "", "POSTS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}