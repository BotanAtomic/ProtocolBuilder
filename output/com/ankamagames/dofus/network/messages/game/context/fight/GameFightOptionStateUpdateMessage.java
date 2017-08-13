package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightOptionStateUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5927;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private int teamId = 2;
    private int option = 3;
    private boolean state = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
         }
         param1.writeShort(this.fightId);
         param1.writeByte(this.teamId);
         param1.writeByte(this.option);
         param1.writeBoolean(this.state);
    }

    public void deserialize(ICustomDataInput param1) {
         this.fightId = param1.readShort();
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element of GameFightOptionStateUpdateMessage.fightId.");
         }
         this.teamId = param1.readByte();
         if(this.teamId < 0)
         {
            throw new Exception("Forbidden value (" + this.teamId + ") on element of GameFightOptionStateUpdateMessage.teamId.");
         }
         this.option = param1.readByte();
         if(this.option < 0)
         {
            throw new Exception("Forbidden value (" + this.option + ") on element of GameFightOptionStateUpdateMessage.option.");
         }
         this.state = param1.readBoolean();
    }

}