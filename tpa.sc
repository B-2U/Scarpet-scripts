// tpa.sc



__config() -> (
   m(
      l('stay_loaded','true')
   )
);

global_requester = null;

__config() -> {
	'commands' -> {
		'<player>' -> _(to) -> signal_event('tp_request', to, player()),
      'accept' -> _() -> if(global_requester, 
         run('tp '+global_requester+' '+player());
         global_requester = null,

         print(format('ir No request now'));
      ),
      'deny' -> _() -> if(global_requester,
         print([player(), global_requester], format(
            'ir request denied.'
         ));
         global_requester = null,

         print(format('ir No request now'));
      )
	},
   'arguments' -> {
      'player' -> {'type' -> 'players', 'single' -> true}
   }
};
handle_event('tp_request', _(req) -> (
   global_requester = req;
   print(format(
      'b '+req+' ',' requested to teleport to you. \nClick ',
      'yb [accept]', '^yb [accept]', '!/tpa accept',
      'w  or ','yb [deny]', '^yb [deny]', '!/tpa deny'
   ));
));