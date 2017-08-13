package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayMountInformations extends GameRolePlayNamedActorInformations implements INetworkType {

    private int protocolId = 180;
    private String ownerName = "";
    private int level = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayActorInformations(param1);
         param1.writeUTF(this.name);
         param1.writeUTF(this.ownerName);
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayNamedActorInformations(param1);
         this.ownerName = param1.readUTF();
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of GameRolePlayMountInformations.level.");
         }
    }

}