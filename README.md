###jRadar
A Surveillance Radar Display Application

The Radar Scope Application has a 3 second cycle time, with a .5 second frame time.
The radar operates at 10 RPM, or 6 seconds of data per scan. Each Overlay
contains newer scan data, thus 6 scans will show 1 minute of history.

All of the Overlays are then displayed in a 3 second cycle.

The radar loads a working buffer with the latest radar data scan. This buffer
is then copied into the top-most echo layer: EchoOverlay1, when that radar
data scan is complete.

Before this can happen, each Overlay is loaded with the previous Overlays
data. Thus, the old EchoOverlay1 data is moved to EchoOverlay2, 2 to 3, 3 to
4, 4 to 5, and finally 5 to 6.

This then provides a 3 second animation history of the last minute of radar data.

Two more layers are needed to complete the display.  At the very top layer is the Track symbology. This is a track block which contains data about the target, along with a speed vector to show direction as determined by echo history. At the very bottom is an opaque layer which will show a map and any special points that have been inserted. The operator can also draw lines, rectangles, or circles in various colors to highlight any areas of the map.
