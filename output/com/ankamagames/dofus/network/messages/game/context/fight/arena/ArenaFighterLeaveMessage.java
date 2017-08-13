package com.ankamagames.dofus.network.messages.game.context.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.CharacterBasicMinimalInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ArenaFighterLeaveMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6700;
    private boolean _isInitialized = false;
    private CharacterBasicMinimalInformations leaver;
    private FuncTree _leavertree;


    public void serialize(ICustomDataOutput param1) {
         this.leaver.serializeAs_CharacterBasicMinimalInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.leaver = new CharacterBasicMinimalInformations();
         this.leaver.deserialize(param1);
    }

}