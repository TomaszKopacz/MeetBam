// Generated code from Butter Knife. Do not modify!
package tomaszkopacz.meetbam.dialogs;

import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public final class CommitPhotoDialog_ViewBinding implements Unbinder {
  private CommitPhotoDialog target;

  private View view2131230853;

  private View view2131230726;

  @UiThread
  public CommitPhotoDialog_ViewBinding(CommitPhotoDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CommitPhotoDialog_ViewBinding(final CommitPhotoDialog target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131230853, "method 'onPairBtnClick'");
    view2131230853 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPairBtnClick();
      }
    });
    view = Utils.findRequiredView(source, 2131230726, "method 'onAcceptBtnClick'");
    view2131230726 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onAcceptBtnClick();
      }
    });
  }

  @Override
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131230853.setOnClickListener(null);
    view2131230853 = null;
    view2131230726.setOnClickListener(null);
    view2131230726 = null;
  }
}
