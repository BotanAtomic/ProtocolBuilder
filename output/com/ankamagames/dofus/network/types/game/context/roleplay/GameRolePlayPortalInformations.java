package package com.ankamagames.dofus.network.types.game.context.roleplay;

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
    private PortalInformation portal = ;
    private FuncTree _portaltree = ;
    private int _loc2_ = param1.readUnsignedShort();


    public int getTypeId() {
         return 467;
    }

    public GameRolePlayPortalInformations initGameRolePlayPortalInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,PortalInformation  param4) {
         super.initGameRolePlayActorInformations(param1,param2,param3);
         this.portal = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.portal = new PortalInformation();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayPortalInformations(param1);
    }

    public void serializeAs_GameRolePlayPortalInformations(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayActorInformations(param1);
         param1.writeShort(this.portal.getTypeId());
         this.portal.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayPortalInformations(param1);
    }

    public void deserializeAs_GameRolePlayPortalInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.portal = ProtocolTypeManager.getInstance(PortalInformation,_loc2_);
         this.portal.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayPortalInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayPortalInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._portaltree = param1.addChild(this._portaltreeFunc);
    }

    private void _portaltreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.portal = ProtocolTypeManager.getInstance(PortalInformation,_loc2_);
         this.portal.deserializeAsync(this._portaltree);
    }

}