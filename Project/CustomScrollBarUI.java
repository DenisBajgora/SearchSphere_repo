/*
 *  Author: Denis Bajgora
 *  Date: 17/04/24
 *  Description:
 * 
 * Extending BasicScrollBarUI, the CustomScrollBarUI class is a customised Java Swing scrollbar
 * that is used to construct unique scrollbars with distinct colours for the track and thumb sections. The class overrides a number of techniques to hide the normal raise
 * and decrease buttons and paint the thumb and track in user-defined colours for a simple, visually cohesive 
 * design.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;


class CustomScrollBarUI extends BasicScrollBarUI {

    private final Color thumbColor; // Color for the scrollbar thumb
    private final Color trackColor; // Color for the scrollbar track

    /**
     * Constructor initializing the UI with specific colors for the thumb and track.
     * @param thumb Color for the thumb part of the scrollbar.
     * @param track Color for the track part of the scrollbar.
     */
    public CustomScrollBarUI(Color thumb, Color track) {
        this.thumbColor = thumb;
        this.trackColor = track;
    }

    /**
     * Configures the scroll bar colors to use the same color for all parts of the thumb.
     * This overrides the default behavior to create a custom appearance.
     */
    @Override
    protected void configureScrollBarColors() {
        this.thumbDarkShadowColor = thumbColor;
        this.thumbLightShadowColor = thumbColor;
        this.thumbHighlightColor = thumbColor;
    }

    /**
     * Creates a zero-sized decrease button to effectively hide it from view.
     * @param orientation The orientation of the scrollbar (unused).
     * @return A JButton that is not visible.
     */
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    /**
     * Creates a zero-sized increase button to effectively hide it from view.
     * @param orientation The orientation of the scrollbar (unused).
     * @return A JButton that is not visible.
     */
    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }

    /**
     * Helper method to create a JButton that takes up no space and is not visible.
     * @return A JButton with no size and not visible.
     */
    private JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(0, 0));
        button.setVisible(false);
        return button;
    }

    /**
     * Paints the scroll bar track using the custom track color.
     * @param g The Graphics context.
     * @param c The component for which this paint method is being called.
     * @param trackBounds The bounds of the track area.
     */
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(trackColor);
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }

    /**
     * Paints the scroll bar thumb using the custom thumb color.
     * If the thumb bounds are empty or the scrollbar is disabled, nothing is painted.
     * @param g The Graphics context.
     * @param c The component for which this paint method is being called.
     * @param thumbBounds The bounds of the thumb area.
     */
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        if (thumbBounds.isEmpty() || !scrollbar.isEnabled()) {
            return;
        }

        g.setColor(thumbColor);
        g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
    }
}
