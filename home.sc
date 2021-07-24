// /home set, and /home tp you back to home
// By _GieR


__config() -> (
    m(
        l('stay_loaded','true')
    )
);

__config() -> {
	'commands' -> {
        'set' -> _() -> (
            if(get_home(player()),
                print('Home updated!'),
                print('Home set!')
            );
            set_home(player())
        ),

        '' -> _() -> (
            home = get_home(player());
            if(home,
                pos = join(' ',home:0);
                dimension = home:1;
                run('execute in '+dimension+' run tp '+player()+' '+join(' ',pos)),

                print(format('w No home detected, enter ','bg /home set ','w first'))
            )
        )

}};

get_home(player) -> (
    home = read_file('homes','json');
    return(home: str(player));
);

set_home(player) -> (
    home = read_file('homes','json');
    if(home==null, home={});
    put(home, player, [pos(player), player ~ 'dimension']);
    write_file('homes','json',home);
)