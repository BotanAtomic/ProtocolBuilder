package com.ankamagames.dofus.network.messages.game.approach;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ServerSettingsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6340;
    private boolean _isInitialized = false;
    private String lang = "";
    private int community = 0;
    private int gameType = -1;
    private int arenaLeaveBanTime = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.lang);
         if(this.community < 0)
         {
            throw new Exception("Forbidden value (" + this.community + ") on element community.");
         }
         param1.writeByte(this.community);
         param1.writeByte(this.gameType);
         if(this.arenaLeaveBanTime < 0)
         {
            throw new Exception("Forbidden value (" + this.arenaLeaveBanTime + ") on element arenaLeaveBanTime.");
         }
         param1.writeVarShort(this.arenaLeaveBanTime);
    }

    public void deserialize(ICustomDataInput param1) {
         this.lang = param1.readUTF();
         this.community = param1.readByte();
         if(this.community < 0)
         {
            throw new Exception("Forbidden value (" + this.community + ") on element of ServerSettingsMessage.community.");
         }
         this.gameType = param1.readByte();
         this.arenaLeaveBanTime = param1.readVarUhShort();
         if(this.arenaLeaveBanTime < 0)
         {
            throw new Exception("Forbidden value (" + this.arenaLeaveBanTime + ") on element of ServerSettingsMessage.arenaLeaveBanTime.");
         }
    }

}