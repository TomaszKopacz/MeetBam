package tomaszkopacz.meetbam.interactor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Ltomaszkopacz/meetbam/interactor/StorageService;", "", "firebaseStorage", "Lcom/google/firebase/storage/FirebaseStorage;", "(Lcom/google/firebase/storage/FirebaseStorage;)V", "uploadFile", "", "file", "Ljava/io/File;", "listener", "Ltomaszkopacz/meetbam/interactor/TaskListener;", "Companion", "app_debug"})
public final class StorageService {
    private final com.google.firebase.storage.FirebaseStorage firebaseStorage = null;
    private static final java.lang.String AVATARS = "avatars";
    public static final tomaszkopacz.meetbam.interactor.StorageService.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String uploadFile(@org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.interactor.TaskListener listener) {
        return null;
    }
    
    public StorageService(@org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.FirebaseStorage firebaseStorage) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Ltomaszkopacz/meetbam/interactor/StorageService$Companion;", "", "()V", "AVATARS", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}