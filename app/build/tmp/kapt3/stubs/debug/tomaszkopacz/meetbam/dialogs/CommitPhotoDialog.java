package tomaszkopacz.meetbam.dialogs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u0018J\b\u0010(\u001a\u00020&H\u0007J\b\u0010)\u001a\u00020&H\u0007R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b#\u0010\n\u00a8\u0006*"}, d2 = {"Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "presenter", "Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialogPresenter;", "(Landroid/content/Context;Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialogPresenter;)V", "acceptBtn", "Landroid/widget/Button;", "getAcceptBtn", "()Landroid/widget/Button;", "acceptBtn$delegate", "Lkotlin/properties/ReadOnlyProperty;", "personTextView", "Landroid/widget/TextView;", "getPersonTextView", "()Landroid/widget/TextView;", "personTextView$delegate", "photoImageView", "Landroid/widget/ImageView;", "getPhotoImageView", "()Landroid/widget/ImageView;", "photoImageView$delegate", "photoUri", "Landroid/net/Uri;", "getPresenter$app_debug", "()Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialogPresenter;", "setPresenter$app_debug", "(Ltomaszkopacz/meetbam/dialogs/CommitPhotoDialogPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "progressBar$delegate", "searchBtn", "getSearchBtn", "searchBtn$delegate", "loadPhoto", "", "uri", "onAcceptBtnClick", "onPairBtnClick", "app_debug"})
public final class CommitPhotoDialog extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadOnlyProperty photoImageView$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadOnlyProperty personTextView$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadOnlyProperty progressBar$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadOnlyProperty searchBtn$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadOnlyProperty acceptBtn$delegate = null;
    private android.net.Uri photoUri;
    @org.jetbrains.annotations.NotNull()
    private tomaszkopacz.meetbam.dialogs.CommitPhotoDialogPresenter presenter;
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getPhotoImageView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPersonTextView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ProgressBar getProgressBar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getSearchBtn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getAcceptBtn() {
        return null;
    }
    
    @butterknife.OnClick(value = {2131230854})
    public final void onPairBtnClick() {
    }
    
    public final void loadPhoto(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
    }
    
    @butterknife.OnClick(value = {2131230726})
    public final void onAcceptBtnClick() {
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