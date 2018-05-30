import gmplot

gmap = gmplot.GoogleMapPlotter(37.428, -122.145, 16)

gmap.plot(latitudes, longitudes, 'cornflowerblue', edge_width=10)
gmap.scatter(more_lats, more_lngs, '#3B0B39', size=40, marker=False)
gmap.scatter(marker_lats, marker_lngs, 'k', marker=True)
gmap.heatmap(heat_lats, heat_lngs)
gmap.heatmap_weighted(heat_lats, heat_lngs, weights)

    map_styles = [
        {
            'featureType': 'all',
            'stylers': [
                {'saturation': -80 },
                {'lightness': 60 },
            ]
        }
    ]

gmap.draw("mymap.html", map_styles=map_styles)
