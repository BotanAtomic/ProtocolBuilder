package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightNewWaveMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6490;
    private boolean _isInitialized = false;
    private int id = 0;
    private int teamId = 2;
    private int nbTurnBeforeNextWave = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeByte(this.id);
         param1.writeByte(this.teamId);
         param1.writeShort(this.nbTurnBeforeNextWave);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readByte();
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of GameFightNewWaveMessage.id.");
         }
         this.teamId = param1.readByte();
         if(this.teamId < 0)
         {
            throw new Exception("Forbidden value (" + this.teamId + ") on element of GameFightNewWaveMessage.teamId.");
         }
         this.nbTurnBeforeNextWave = param1.readShort();
    }

}