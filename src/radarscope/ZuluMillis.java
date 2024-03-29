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

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ZuluMillis {

    private static final Calendar cal = new GregorianCalendar();

    /**
     * Method to return the current UTC "zulu" time
     *
     * @return a long Representing the UTC time.
     */
    public long getUTCTime() {
        cal.setTimeInMillis(System.currentTimeMillis());

        return cal.getTimeInMillis()
                - cal.get(Calendar.ZONE_OFFSET)
                - cal.get(Calendar.DST_OFFSET);
    }
}
