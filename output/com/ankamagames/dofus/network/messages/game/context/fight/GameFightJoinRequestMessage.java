package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightJoinRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 701;
    private boolean _isInitialized = false;
    private Number fighterId = 0;
    private int fightId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.fighterId < -9.007199254740992E15 || this.fighterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fighterId + ") on element fighterId.");
         }
         param1.writeDouble(this.fighterId);
         param1.writeInt(this.fightId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.fighterId = param1.readDouble();
         if(this.fighterId < -9.007199254740992E15 || this.fighterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fighterId + ") on element of GameFightJoinRequestMessage.fighterId.");
         }
         this.fightId = param1.readInt();
    }

}