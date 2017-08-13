package package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayTaxCollectorInformations extends GameRolePlayActorInformations implements INetworkType {

    private int protocolId = 148;
    private TaxCollectorStaticInformations identification = ;
    private int guildLevel = 0;
    private int taxCollectorAttack = 0;
    private FuncTree _identificationtree = ;
    private int _loc2_ = param1.readUnsignedShort();


    public int getTypeId() {
         return 148;
    }

    public GameRolePlayTaxCollectorInformations initGameRolePlayTaxCollectorInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,TaxCollectorStaticInformations  param4,int  param5,int  param6) {
         super.initGameRolePlayActorInformations(param1,param2,param3);
         this.identification = param4;
         this.guildLevel = param5;
         this.taxCollectorAttack = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.identification = new TaxCollectorStaticInformations();
         this.taxCollectorAttack = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayTaxCollectorInformations(param1);
    }

    public void serializeAs_GameRolePlayTaxCollectorInformations(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayActorInformations(param1);
         param1.writeShort(this.identification.getTypeId());
         this.identification.serialize(param1);
         if(this.guildLevel < 0 || this.guildLevel > 255)
            throw new Exception("Forbidden value (" + this.guildLevel + ") on element guildLevel.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayTaxCollectorInformations(param1);
    }

    public void deserializeAs_GameRolePlayTaxCollectorInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.identification = ProtocolTypeManager.getInstance(TaxCollectorStaticInformations,_loc2_);
         this.identification.deserialize(param1);
         this._guildLevelFunc(param1);
         this._taxCollectorAttackFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayTaxCollectorInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayTaxCollectorInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._identificationtree = param1.addChild(this._identificationtreeFunc);
         param1.addChild(this._guildLevelFunc);
         param1.addChild(this._taxCollectorAttackFunc);
    }

    private void _identificationtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.identification = ProtocolTypeManager.getInstance(TaxCollectorStaticInformations,_loc2_);
         this.identification.deserializeAsync(this._identificationtree);
    }

    private void _guildLevelFunc(ICustomDataInput param1) {
         this.guildLevel = param1.readUnsignedByte();
         if(this.guildLevel < 0 || this.guildLevel > 255)
            throw new Exception("Forbidden value (" + this.guildLevel + ") on element of GameRolePlayTaxCollectorInformations.guildLevel.");
    }

    private void _taxCollectorAttackFunc(ICustomDataInput param1) {
         this.taxCollectorAttack = param1.readInt();
    }

}