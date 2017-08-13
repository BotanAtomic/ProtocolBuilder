package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayTaxCollectorInformations extends GameRolePlayActorInformations implements INetworkType {

    private int protocolId = 148;
    private TaxCollectorStaticInformations identification;
    private int guildLevel = 0;
    private int taxCollectorAttack = 0;
    private FuncTree _identificationtree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameContextActorInformations(param1);
         param1.writeShort(this.identification.getTypeId());
         this.identification.serialize(param1);
         if(this.guildLevel < 0 || this.guildLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.guildLevel + ") on element guildLevel.");
         }
         param1.writeByte(this.guildLevel);
         param1.writeInt(this.taxCollectorAttack);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayActorInformations(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.identification = ProtocolTypeManager.getInstance(TaxCollectorStaticInformations,_loc2_);
         this.identification.deserialize(param1);
         this.guildLevel = param1.readUnsignedByte();
         if(this.guildLevel < 0 || this.guildLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.guildLevel + ") on element of GameRolePlayTaxCollectorInformations.guildLevel.");
         }
         this.taxCollectorAttack = param1.readInt();
    }

}