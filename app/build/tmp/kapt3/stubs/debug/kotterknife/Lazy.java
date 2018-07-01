package kotterknife;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001\u000eB#\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\"\u0010\n\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0096\u0002\u00a2\u0006\u0002\u0010\rR$\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lkotterknife/Lazy;", "T", "V", "Lkotlin/properties/ReadOnlyProperty;", "initializer", "Lkotlin/Function2;", "Lkotlin/reflect/KProperty;", "(Lkotlin/jvm/functions/Function2;)V", "value", "", "getValue", "thisRef", "property", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "EMPTY", "app_debug"})
final class Lazy<T extends java.lang.Object, V extends java.lang.Object> implements kotlin.properties.ReadOnlyProperty<T, V> {
    private java.lang.Object value;
    private final kotlin.jvm.functions.Function2<T, kotlin.reflect.KProperty<?>, V> initializer = null;
    
    @java.lang.Override()
    public V getValue(T thisRef, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KProperty<?> property) {
        return null;
    }
    
    public Lazy(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super T, ? super kotlin.reflect.KProperty<?>, ? extends V> initializer) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lkotterknife/Lazy$EMPTY;", "", "()V", "app_debug"})
    static final class EMPTY {
        public static final kotterknife.Lazy.EMPTY INSTANCE = null;
        
        private EMPTY() {
            super();
        }
    }
}