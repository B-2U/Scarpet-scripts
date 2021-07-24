// chest and shulker box can be opened even its blocked by solid blocks
// By _GieR


__config() -> (
   m(
      l('stay_loaded','true')
   )
);


__on_player_right_clicks_block(player, item_tuple, hand, block, face, hitvec)->(
    if(
        block ~ 'chest', 
            facing = 'up';
            if(block_state(pos(block)):'type' != 'single', //deal with double chest
                neighbour_blocks = {};
                for(neighbours(pos(block)),
                    neighbour_blocks += block(pos_offset(_, 'up', 1))
                );
                _block_check(neighbour_blocks)
            ),

        block ~ 'shulker_box',
            facing = block_state(pos(block)):'facing',

        return() //else, both not        
    );
    target = block(pos_offset(block, facing, 1));
    _block_check({target})
);
_block_check(blocks) -> (
    for(blocks,
        if(solid(_),
        without_updates(set(pos(_), 'air'));
        schedule(0, '_place_back', pos(_), _)
        )   
    )
);
_place_back(pos, block)->(
    without_updates(set(pos, block));
)
