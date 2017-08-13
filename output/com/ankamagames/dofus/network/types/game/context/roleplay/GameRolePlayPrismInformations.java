package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.prism.PrismInformation;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayPrismInformations extends GameRolePlayActorInformations implements INetworkType {

    private int protocolId = 161;
    private PrismInformation prism;
    private FuncTree _prismtree;


    public int getTypeId() {
         return 161;
    }

    public GameRolePlayPrismInformations initGameRolePlayPrismInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,PrismInformation  param4) {
         super.initGameRolePlayActorInformations(param1,param2,param3);
         this.prism = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.prism = new PrismInformation();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayPrismInformations(param1);
    }

    public void serializeAs_GameRolePlayPrismInformations(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayActorInformations(param1);
         param1.writeShort(this.prism.getTypeId());
         this.prism.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayPrismInformations(param1);
    }

    public void deserializeAs_GameRolePlayPrismInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.prism = ProtocolTypeManager.getInstance(PrismInformation,_loc2_);
         this.prism.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayPrismInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayPrismInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._prismtree = param1.addChild(this._prismtreeFunc);
    }

    private void _prismtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.prism = ProtocolTypeManager.getInstance(PrismInformation,_loc2_);
         this.prism.deserializeAsync(this._prismtree);
    }

}