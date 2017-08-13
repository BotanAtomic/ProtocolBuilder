package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.FightStartingPositions;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MapFightStartPositionsUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6716;
    private boolean _isInitialized = false;
    private int mapId = 0;
    private FightStartingPositions fightStartPositions;
    private FuncTree _fightStartPositionstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.mapId < 0)
         {
            throw new Exception("Forbidden value (" + this.mapId + ") on element mapId.");
         }
         param1.writeInt(this.mapId);
         this.fightStartPositions.serializeAs_FightStartingPositions(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.mapId = param1.readInt();
         if(this.mapId < 0)
         {
            throw new Exception("Forbidden value (" + this.mapId + ") on element of MapFightStartPositionsUpdateMessage.mapId.");
         }
         this.fightStartPositions = new FightStartingPositions();
         this.fightStartPositions.deserialize(param1);
    }

}