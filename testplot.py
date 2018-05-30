from gmplot import gmplot
# Place map
gmap = gmplot.GoogleMapPlotter(18.53137, 73.86019, 13)
# Polygon

# Scatter points
top_attraction_lats, top_attraction_lons = zip(*[
    (18.53137, 73.86019),
    (18.53150, 73.86099),
    (18.53160, 73.86100),
    (18.53160, 73.86180),
    (18.53150, 73.86099),
    (18.53155, 73.86100),
    (18.53137, 73.86019),
    (18.53150, 73.86099),
    (18.53155, 73.86100),
    (18.53137, 73.86019),
    (18.53150, 73.86099),
    (18.53155, 73.86100)
    ])
gmap.scatter(top_attraction_lats, top_attraction_lons, '#3B0B39', size=40, marker=False)

# Marker
hidden_gem_lat, hidden_gem_lon = 18.53137, 73.86019
gmap.marker(hidden_gem_lat, hidden_gem_lon, 'cornflowerblue')

# Draw
gmap.draw("my_map.html")