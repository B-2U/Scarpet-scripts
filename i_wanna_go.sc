// enter the target coordination and you will face toward your destination, just keep walking/flying forward
// By _GieR


__config() -> (
    m(
        l('stay_loaded','true')
    )
);


__config() -> {
	'commands' -> {
		'<destination>' -> _(des) -> (
            vector = [des:0-pos(player()):0, des:2-pos(player()):2];
            deg = asin(vector:0 / sqrt(vector:0*vector:0 + vector:1*vector:1)) * -1;
            if(vector:1 < 0,
                if(
                    deg > 0,
                        deg = 180 - deg,
                    deg < 0,
                        deg = -180 - deg
                )
            );
            modify(player(), 'yaw', deg);
            print(format('y You are facing ' + des +' now, let\'s go!'))
        ),
        '' -> _() ->(print(format('y Enter the target XYZ and you will face toward your destination, just keep walking/flying forward')))
	},
    'arguments' -> {
        'destination' -> {'type' -> 'location', 'block_centered' -> true}
    }
}