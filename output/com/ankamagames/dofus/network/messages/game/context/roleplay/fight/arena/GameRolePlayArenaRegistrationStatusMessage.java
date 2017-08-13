package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayArenaRegistrationStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6284;
    private boolean _isInitialized = false;
    private boolean registered = false;
    private int step = 0;
    private int battleMode = 3;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.registered);
         param1.writeByte(this.step);
         param1.writeInt(this.battleMode);
    }

    public void deserialize(ICustomDataInput param1) {
         this.registered = param1.readBoolean();
         this.step = param1.readByte();
         if(this.step < 0)
         {
            throw new Exception("Forbidden value (" + this.step + ") on element of GameRolePlayArenaRegistrationStatusMessage.step.");
         }
         this.battleMode = param1.readInt();
         if(this.battleMode < 0)
         {
            throw new Exception("Forbidden value (" + this.battleMode + ") on element of GameRolePlayArenaRegistrationStatusMessage.battleMode.");
         }
    }

}