package Framework.ui.common;

import java.util.List;

/**
 * This functional interface class will be used in
 * BaseDialog and BaseMainJFrame when click the <i><b>Ok</b></i> button
 *
 * @author MinPhone, Seid, Asrat
 * @see Framework.ui.base.BaseDialog
 * @see Framework.ui.base.BaseMainJFrame
 */
@FunctionalInterface
public interface OkSubmitDelegate {

    /**
     * @param values provide all the data of current screen.
     */
    void onSubmitClicked(List<String> values);

}
