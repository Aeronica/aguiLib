package net.aeronica.modlibs.aguilib.server.property.wrapper;


import net.aeronica.modlibs.aguilib.server.property.IIntProperty;

import java.text.NumberFormat;

/**
 * Wraps an IIntProperty as IIntProperty, IDoubleProperty, IFloatProperty and IStringProperty.
 */
public class IntPropertyWrapper extends IntPropertyWrapperBase<IIntProperty> {
    public IntPropertyWrapper(int value, NumberFormat numberFormat) {
        this(new IIntProperty.WithState(value), numberFormat);
    }

    public IntPropertyWrapper(IIntProperty delegateFor, NumberFormat numberFormat) {
        super(delegateFor, numberFormat);
    }
}
