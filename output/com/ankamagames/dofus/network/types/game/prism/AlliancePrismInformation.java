package com.ankamagames.dofus.network.types.game.prism;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AlliancePrismInformation extends PrismInformation implements INetworkType {

    private int protocolId = 427;
    private AllianceInformations alliance;
    private FuncTree _alliancetree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_PrismInformation(param1);
         this.alliance.serializeAs_AllianceInformations(param1);
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
         this.prism = ProtocolTypeManager.getInstance(PrismInformation,_loc2_);
         this.prism.deserialize(param1);
         this.alliance = new AllianceInformations();
         this.alliance.deserialize(param1);
    }

}