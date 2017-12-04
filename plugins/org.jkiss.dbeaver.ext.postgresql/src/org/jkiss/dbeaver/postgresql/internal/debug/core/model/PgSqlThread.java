package org.jkiss.dbeaver.postgresql.internal.debug.core.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.jkiss.dbeaver.debug.core.model.DatabaseDebugElement;
import org.jkiss.dbeaver.debug.core.model.IDatabaseDebugTarget;
import org.jkiss.dbeaver.postgresql.debug.core.PgSqlDebugCore;

public class PgSqlThread extends DatabaseDebugElement implements IThread {

    public PgSqlThread(IDatabaseDebugTarget target)
    {
        super(PgSqlDebugCore.MODEL_IDENTIFIER, target);
    }

    @Override
    public boolean canResume()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canSuspend()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isSuspended()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void resume() throws DebugException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void suspend() throws DebugException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean canStepInto()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canStepOver()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canStepReturn()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isStepping()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void stepInto() throws DebugException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void stepOver() throws DebugException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void stepReturn() throws DebugException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean canTerminate()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTerminated()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void terminate() throws DebugException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public IStackFrame[] getStackFrames() throws DebugException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasStackFrames() throws DebugException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getPriority() throws DebugException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public IStackFrame getTopStackFrame() throws DebugException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() throws DebugException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IBreakpoint[] getBreakpoints()
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void resumedByTarget()
    {
        // TODO Auto-generated method stub
        
    }

    public void setStepping(boolean b)
    {
        // TODO Auto-generated method stub
        
    }

}
