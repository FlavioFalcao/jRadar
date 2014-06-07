/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package radarscope;

import java.util.Locale;

/*
 * Program to display objects on a radarscope
 *
 * The radar scope operates on a three second display cycle time.
 *
 * The display cycle time is further divided into six frame snapshots. The
 * snapshots are 500 milliseconds long (1/2 second).
 *
 * Each frame is used to add items to the radar scope. We have 1/2 second to
 * fill the first layer (bottom), 1/2 second for the next layer, and finally
 * after 2.5 seconds we have the top layer. We then repeat the process every 3
 * seconds.
 *
 * The bottom layer is opaque, but the five layers above are translucent. We
 * draw the map and fixed objects on the bottom, so the upper layers will show
 * the moving targets against this background.
 *
 * Since we are generating the next cycle now, it will become three seconds
 * behind real-time. You have to wait three seconds to finish the first cycle.
 *
 * Echo history, for example, will have one echo on each layer, so that in three
 * seconds time, it will have moved six times across the scope. A Flashing ident
 * symbol needs to flash on for one second and off for one second, so every two
 * layers has the ident symbol, and two layers do not. Since there is an odd
 * number of pairs, one three second cycle is called the even cycle, and the
 * other is the odd cycle, and you toggle between the two.
 *
 * The six frames in each cycle are fixed. You can't throw a layer away, you
 * have to throw the whole cycle away.
 */
public class Main {

    public static final long CYCLE_TIME = 3000;                             // milliseconds
    public static final long SNAPSHOT_TIME = (CYCLE_TIME / 6L);             // milliseconds (500 ms)
    public static final int DISPLAY_LAYERS = (int)(CYCLE_TIME / SNAPSHOT_TIME); // 6 layers

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        java.awt.EventQueue.invokeLater(() -> {
            new RadarScope(DISPLAY_LAYERS).setVisible(true);
        });
    }
}
