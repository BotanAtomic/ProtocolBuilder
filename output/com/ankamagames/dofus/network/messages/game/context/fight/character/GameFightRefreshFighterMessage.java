package com.ankamagames.dofus.network.messages.game.context.fight.character;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.GameContextActorInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class GameFightRefreshFighterMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6309;
    private boolean _isInitialized = false;
    private GameContextActorInformations informations;
    private FuncTree _informationstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.informations.getTypeId());
         this.informations.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.informations = ProtocolTypeManager.getInstance(GameContextActorInformations,_loc2_);
         this.informations.deserialize(param1);
    }

}