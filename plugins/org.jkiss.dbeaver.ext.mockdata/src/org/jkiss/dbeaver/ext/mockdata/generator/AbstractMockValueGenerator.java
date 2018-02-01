package org.jkiss.dbeaver.ext.mockdata.generator;

import org.jkiss.dbeaver.DBException;
import org.jkiss.dbeaver.ext.mockdata.model.MockValueGenerator;
import org.jkiss.dbeaver.model.struct.DBSAttributeBase;
import org.jkiss.dbeaver.model.struct.DBSDataManipulator;
import org.jkiss.utils.CommonUtils;

import java.util.Map;
import java.util.Random;

public abstract class AbstractMockValueGenerator implements MockValueGenerator {

    protected static Random random = new Random();
    protected boolean allowNulls;

    @Override
    public void init(DBSDataManipulator container, DBSAttributeBase attribute, Map<Object, Object> properties) throws DBException {
        allowNulls = !attribute.isRequired() && Boolean.valueOf(CommonUtils.toString(properties.get("nulls")));
    }

    @Override
    public void nextRow() {
    }

    @Override
    public void dispose() {
    }

    protected boolean isGenerateNULL() {
        if (allowNulls && (random.nextInt() % 10 == 1)) { // TODO every 10th is NULL - can be customized in the future
            return true;
        }
        else {
            return false;
        }
    }
}
