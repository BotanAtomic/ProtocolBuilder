package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayAggressionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6073;
    private boolean _isInitialized = false;
    private Number attackerId = 0;
    private Number defenderId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.attackerId < 0 || this.attackerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.attackerId + ") on element attackerId.");
         }
         param1.writeVarLong(this.attackerId);
         if(this.defenderId < 0 || this.defenderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.defenderId + ") on element defenderId.");
         }
         param1.writeVarLong(this.defenderId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.attackerId = param1.readVarUhLong();
         if(this.attackerId < 0 || this.attackerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.attackerId + ") on element of GameRolePlayAggressionMessage.attackerId.");
         }
         this.defenderId = param1.readVarUhLong();
         if(this.defenderId < 0 || this.defenderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.defenderId + ") on element of GameRolePlayAggressionMessage.defenderId.");
         }
    }

}