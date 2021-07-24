// tp back to where you died
// By _GieR


__config() -> (
    m(
        l('stay_loaded','true')
    )
);


global_dead_pos = null;

__on_player_dies(player) -> (
    global_dead_pos = [pos(player), player~'dimension'];
    schedule(2,'msg', pos(player), player~'dimension');
);


__command() -> (
    if(global_dead_pos,
    [pos, dimension] = global_dead_pos;
    run('execute in '+dimension+' run tp '+player()+' '+join(' ',pos));

    global_dead_pos = null;
    );
    null
);


msg(pos, dimension)->(
    round_pos =[];
    for(pos, put(round_pos, null, round(_)));
    print(format(
    'ib OOF, ', 'w do you want to go back? Click -> ',
    'yb [back]', '^yb tp to '+round_pos+' in '+dimension, '!/back'))
)