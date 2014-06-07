/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package radarscope;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JComponent;

/**
 * Radar Scope has 3 second cycle time, .5 second frame time
 *
 * The radar operates at 10 RPM, or 6 seconds of data per scan. Each Overlay
 * contains newer scan data, thus 6 scans can show 1 minute of history. All of
 * the Overlays are then displayed in a 3 second cycle.
 *
 * The radar loads a working buffer with the latest radar data scan. This buffer
 * is then copied into the top-most echo layer: EchoOverlay1, when this radar
 * data scan is complete.
 *
 * Before this can happen, each Overlay is loaded with the previous Overlays
 * data. Thus, the old EchoOverlay1 data is moved to EchoOverlay2, 2 to 3, 3 to
 * 4, 4 to 5, and finally 5 to 6.
 *
 * This then provides a 3 second animation history of the last minute of radar
 * data.
 */
public class JRadarComponent extends JComponent {

    protected BufferedImage BaseOverlay;        // layer for maps, special points (Lowest Layer, Opaque)
    //
    protected BufferedImage TrackOverlay;       // layer for Track Symbology (Highest layer, Transparent)
    //
    protected BufferedImage EchoOverlay1;       // layer for echoes 0.0 seconds ago (Transparent) 
    protected BufferedImage EchoOverlay2;       // layer for echoes 0.5 seconds ago (Transparent)
    protected BufferedImage EchoOverlay3;       // layer for echoes 1.0 seconds ago (Transparent)
    protected BufferedImage EchoOverlay4;       // layer for echoes 1.5 seconds ago (Transparent)
    protected BufferedImage EchoOverlay5;       // layer for echoes 2.0 seconds ago (Transparent)
    protected BufferedImage EchoOverlay6;       // layer for echoes 2.5 seconds ago (Transparent)

    /*
     * Using the underlying int[] values and arraycopy for speed
     * This layer is shown along with the track and echo overlays
     */
    public void updateBaseOverlayLayer() {
        int[] data = new int[getPreferredSize().width * getPreferredSize().height];
        DataBufferInt result = new DataBufferInt(data, data.length);

        BufferedImage baseOverlay = new BufferedImage(getPreferredSize().width, getPreferredSize().height, BufferedImage.TYPE_INT_ARGB);
        int[] baseLayer = ((DataBufferInt) baseOverlay.getRaster().getDataBuffer()).getData();
        System.arraycopy(data, 0, baseLayer, 0, data.length); // data -> baseLayer
    }

    public void updateTrackOverlayLayer() {
    }

    public void updateEchoOverlay1() {
    }

    public void updateEchoOverlay2() {
    }

    public void updateEchoOverlay3() {
    }

    public void updateEchoOverlay4() {
    }

    public void updateEchoOverlay5() {
    }

    public void updateEchoOverlay6() {
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension();
    }
}
