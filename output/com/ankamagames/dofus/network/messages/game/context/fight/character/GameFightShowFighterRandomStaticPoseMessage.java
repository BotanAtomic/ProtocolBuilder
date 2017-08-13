package com.ankamagames.dofus.network.messages.game.context.fight.character;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightFighterInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightShowFighterRandomStaticPoseMessage extends GameFightShowFighterMessage implements INetworkMessage {

    private int protocolId = 6218;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameFightShowFighterMessage(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.informations = ProtocolTypeManager.getInstance(GameFightFighterInformations,_loc2_);
         this.informations.deserialize(param1);
    }

}