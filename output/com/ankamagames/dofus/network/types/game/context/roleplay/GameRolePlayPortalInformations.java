package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt.PortalInformation;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayPortalInformations extends GameRolePlayActorInformations implements INetworkType {

    private int protocolId = 467;
    private PortalInformation portal;
    private FuncTree _portaltree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayActorInformations(param1);
         param1.writeShort(this.portal.getTypeId());
         this.portal.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.contextualId = param1.readDouble();
         if(this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.contextualId + ") on element of GameContextActorInformations.contextualId.");
         }
         this.look = new EntityLook();
         this.look.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.disposition = ProtocolTypeManager.getInstance(EntityDispositionInformations,_loc2_);
         this.disposition.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.portal = ProtocolTypeManager.getInstance(PortalInformation,_loc2_);
         this.portal.deserialize(param1);
    }

}