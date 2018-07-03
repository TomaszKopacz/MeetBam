package tomaszkopacz.meetbam.dialogs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000eR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "presenter", "Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialogPresenter;", "(Landroid/content/Context;Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialogPresenter;)V", "photoUri", "Landroid/net/Uri;", "getPresenter$app_debug", "()Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialogPresenter;", "setPresenter$app_debug", "(Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialogPresenter;)V", "loadPhoto", "", "uri", "notifyUserPaired", "user", "Ltomaszkopacz/meetbam/entity/User;", "pairInProgress", "app_debug"})
public final class CommitPhotoDialog extends android.app.Dialog {
    private android.net.Uri photoUri;
    @org.jetbrains.annotations.NotNull()
    private tomaszkopacz.meetbam.dialogs.CommitPhotoDialogPresenter presenter;
    
    public final void loadPhoto(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
    }
    
    public final void pairInProgress() {
    }
    
    public final void notifyUserPaired(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.entity.User user) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tomaszkopacz.meetbam.dialogs.CommitPhotoDialogPresenter getPresenter$app_debug() {
        return null;
    }
    
    public final void setPresenter$app_debug(@org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.dialogs.CommitPhotoDialogPresenter p0) {
    }
    
    public CommitPhotoDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    tomaszkopacz.meetbam.dialogs.CommitPhotoDialogPresenter presenter) {
        super(null);
    }
}