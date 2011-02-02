/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgolXXI.Editor;

import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CallableSystemAction;

public final class GuardarComo extends CallableSystemAction {

    public void performAction() {
        ProgramaTopComponent ptc = AlgolXXI.Editor.Utils.EditorUtils.getTopComponent();
        if (ptc != null) {
            ptc.guardarcomo();
        }
    }

    public String getName() {
        return NbBundle.getMessage(GuardarComo.class, "CTL_GuardarComo");
    }

    @Override
    protected String iconResource() {
        return "AlgolXXI/Editor/Images/saveas.png";
    }

    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }
}
