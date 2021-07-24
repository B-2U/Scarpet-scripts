// break the whole tree when using axe but not sneaking
// By _GieR


__config() -> (
    m(
        l('stay_loaded','true')
    )
);


__on_player_breaks_block(player, block) -> (
    item = player()~'holds':0;
    if(item ~ '_axe' && !query(player, 'sneaking') && block ~ '_log',
        for(rect(pos(block),0,0,0, 0,32,0),
            if(
                _ == block && pos(_) != pos(block),
                    harvest(player, pos(_)),

                _ != block,
                    break()
            )
        )
    )
)